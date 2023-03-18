package study.querydsl.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.util.Locale;

import static com.p6spy.engine.logging.Category.STATEMENT;
import static org.hibernate.engine.jdbc.internal.FormatStyle.BASIC;
import static org.hibernate.engine.jdbc.internal.FormatStyle.DDL;

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

//        final String formattedSql = formatSql(sql);
        final String formattedSql = formatSql2(sql, category);

        return now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + LINE_SEPARATOR + formattedSql + ";";
    }

    private static String formatSql2(String sql) {

        if (sql == null || sql.trim().isEmpty()) {
            return sql;
        }

        return sql.trim()
                .replace("select ", "select" + LINE_SEPARATOR + "    ")
                .replace(" from ", LINE_SEPARATOR + "from" + LINE_SEPARATOR + "    ")
                .replace(" where ", LINE_SEPARATOR + "where" + LINE_SEPARATOR + "    ")
                .replace(" and ", LINE_SEPARATOR + "  and ")
                .replace(" or ", LINE_SEPARATOR + "   or ");
    }

    private static String formatSql2(String sql, String category) {

        if (sql == null || sql.trim().isEmpty()) {
            return sql;
        }

        if (isStatement(category)) {

            String prefixStatement = sql.trim().toLowerCase(Locale.ROOT);

            if (isDDL(prefixStatement)) {
                return DDL.getFormatter().format(sql);
            }

            return BASIC.getFormatter().format(sql);
        }

        return sql;
    }

    private static boolean isStatement(String category) {
        return STATEMENT.getName().equals(category);
    }

    private static boolean isDDL(String prefixStatement) {
        return prefixStatement.startsWith("create")
                || prefixStatement.startsWith("alter")
                || prefixStatement.startsWith("comment");
    }
}
