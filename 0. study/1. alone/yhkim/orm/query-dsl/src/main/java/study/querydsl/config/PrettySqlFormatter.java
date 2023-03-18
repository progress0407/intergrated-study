package study.querydsl.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * p6spy
 */
public class PrettySqlFormatter implements MessageFormattingStrategy {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Override
    public String formatMessage(int connectionId,
                                String now,
                                long elapsed,
                                String category,
                                String prepared,
                                String sql,
                                String url) {

        final String formattedSql = formatSql(sql);
        if (sql == null) return "";

        return now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + LINE_SEPARATOR + formattedSql + ";";
    }

    private static String formatSql(String sql) {

        if (sql == null || sql.trim().isEmpty()) {
            return null;
        }

        return sql.trim()
                .replace("select ", "select" + LINE_SEPARATOR + "    ")
                .replace(" from ", LINE_SEPARATOR + "from" + LINE_SEPARATOR + "    ")
                .replace(" where ", LINE_SEPARATOR + "where" + LINE_SEPARATOR + "    ")
                .replace(" and ", LINE_SEPARATOR + "  and ")
                .replace(" or ", LINE_SEPARATOR + "   or ");
    }
}
