package hello.gorm.service.util

import io.r2dbc.h2.H2Row
import org.springframework.data.r2dbc.core.DatabaseClient

class SqlViaFlux{

    static runSqlExpectingVoidReturned(final DatabaseClient client, final String sql) {
        def what = client.execute().sql(sql).then().log()
                .block()
        what
    }

    static runSqlExpectingListAsAnswer(final DatabaseClient client, final String sql) {
        def what = client.execute().sql(sql)
                .map(
                { H2Row r, m -> r.toString() }
        ).all().toIterable().asList()
        what
    }

    static runSqlExpectingSingleAnswer(final DatabaseClient client, final String sql, final String namePicker ) {
        def what = client.execute().sql(sql)
                .map(
                { H2Row r, m -> r.get(namePicker) }
        ).one().log().block()
        what
    }

}
