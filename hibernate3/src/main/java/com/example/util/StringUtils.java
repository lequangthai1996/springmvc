package com.example.util;

public class StringUtils {

	public static String buildSelectQuery(String[] columns, String[] tables, String[] defaultConditions) {
		// TODO Auto-generated method stub
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append(String.join(", ", columns));
		query.append(" FROM ");
		query.append(String.join(" ", tables));
		query.append(" WHERE ");
		query.append(String.join(" AND ", defaultConditions) );
		return query.toString();
	}
    public static Long convertStringToLongOrNull(String input) {
        try {
            return Long.valueOf(input);
        } catch (Exception e) {
            return null;
        }
    }
    public static String buildFullNameSQLCastToVarchar(String lastName, String midName, String firstName) {
        return rawCastToVarchar(buildFullNameSQL(lastName, midName, firstName));
    }
    public static String buildFullNameSQLWithLower(String lastName, String midName, String firstName) {
        return toSQLLower(buildFullNameSQL(lastName, midName, firstName));
    }
    public static String rawCastToVarchar(String key) {
        return "utl_raw.cast_to_varchar2((nlssort(lower(" + key + "),'nls_sort=binary_ai')))";
    }
    public static String toSQLLower(String field) {
        return new StringBuilder("lower(").append(field).append(")").toString();
    }
//    public static String buildFullNameSQL(String lastName, String midName, String firstName) {
//        StringBuilder fullName = new StringBuilder();
//        fullName.append("((case when ");
//        fullName.append(lastName);
//        fullName.append(" is null then '' else ");
//        fullName.append(lastName);
//        fullName.append(" end) || (case when ");
//        fullName.append(midName);
//        fullName.append(" is null then '' else ");
//        fullName.append("CONCAT(' ', " + midName + ")");
//        fullName.append(" end) || (case when ");
//        fullName.append(firstName);
//        fullName.append(" is null then '' else ");
//        fullName.append("CONCAT(' ', " + firstName + ")");
//        fullName.append(" end))");
//        return fullName.toString();
//    }  
    public static String buildFullNameSQL(String lastName, String midName, String firstName) {
        StringBuilder fullName = new StringBuilder();
        fullName.append("concat(staff.last_name, ' ', staff.mid_name, ' ', staff.first_name)");
        return fullName.toString();
    }
    
    public static String buildFullNameSQLHQL(String lastName, String midName, String firstName) {
        StringBuilder fullName = new StringBuilder();
        fullName.append("concat(staff.lastName, ' ', staff.midName, ' ', staff.firstName)");
        return fullName.toString();
    }
    public static boolean isStringAscii(String str) {
        for (char ch : str.toCharArray()) {
            if (!isAscii(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscii(char ch) {
        return ch < 128;
    }
	public static String buildGroupsByQuery(String[] groupBys) {
		// TODO Auto-generated method stub
		StringBuilder groupByQuery = new StringBuilder();
		groupByQuery.append(" GROUP BY ");
		groupByQuery.append(String.join(", ", groupBys));
		return groupByQuery.toString();
	}
	public static void main(String[] args) {
		String[] group = {"staff.id", "staff.code"};
		System.out.println(buildGroupsByQuery(group));
	}

}
