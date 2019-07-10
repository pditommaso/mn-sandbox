package gormdemo.controller


import gormdemo.domain.Foo
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Slf4j
@Controller("/foo")
class FooController {

    @Get("/list")
    HttpResponse<Foo> list() {
        HttpResponse.ok(new Foo(tokens: []))
    }

}
