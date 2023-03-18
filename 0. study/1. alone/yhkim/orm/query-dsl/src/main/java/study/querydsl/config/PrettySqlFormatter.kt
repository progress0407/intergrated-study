package study.querydsl.config

import com.p6spy.engine.logging.Category
import com.p6spy.engine.spy.appender.MessageFormattingStrategy
import org.hibernate.engine.jdbc.internal.FormatStyle
import org.springframework.util.StringUtils.hasText

class PrettySqlFormatter : MessageFormattingStrategy {
    override fun formatMessage(
        connectionId: Int,
        now: String,
        elapsed: Long,
        category: String,
        prepared: String,
        sql: String,
        url: String
    ): String {

        val formattedSql: String = formatSql(sql, category)

        return now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + LINE_SEPARATOR + formattedSql + ";"
    }

    companion object {

        private val LINE_SEPARATOR = System.getProperty("line.separator")

        private fun formatSql(sql: String?, category: String): String {

            if (!hasText(sql)) {
                return ""
            }

            sql!!

            if (isStatement(category)) {
                val prefixStatement: String = sql.trim().lowercase()

                if (isDDL(prefixStatement)) {
                    return FormatStyle.DDL.formatter.format(sql)
                }

                // DML case
                return FormatStyle.BASIC.formatter.format(sql)
            }

            return sql
        }

        private fun isStatement(category: String): Boolean =
            Category.STATEMENT.name == category

        private fun isDDL(prefixStatement: String): Boolean =
            (prefixStatement.startsWith("create")
                    || prefixStatement.startsWith("alter")
                    || prefixStatement.startsWith("comment"))
    }
}