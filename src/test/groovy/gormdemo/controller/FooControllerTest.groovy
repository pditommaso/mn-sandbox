package gormdemo.controller

import javax.inject.Inject

import gormdemo.Application
import gormdemo.domain.Foo
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@MicronautTest(application = Application.class)
class FooControllerTest extends Specification {

    @Inject
    @Client('/')
    RxHttpClient client

    def 'should return an empty list' () {
        when:
        HttpResponse<Foo> response = client
                .toBlocking()
                .exchange( HttpRequest.GET("/foo/list"), Foo.class )

        then:
        response.status == HttpStatus.OK
        response.body().tokens.size() == 0
//              
//
//        response.body().tokens.size() == 0
//        |        |      |      |
//        |        |      null   java.lang.NullPointerException: Cannot invoke method size() on null object
//        |        <gormdemo.domain.Foo@6daf7d37 message=null tokens=null>
//                <io.micronaut.http.client.FullNettyClientHttpResponse@435e60ff status=OK headers=io.micronaut.http.netty.NettyHttpHeaders@2e6f610d attributes={} nettyHttpResponse=HttpObjectAggregator$AggregatedFullHttpResponse(decodeResult: success, version: HTTP/1.1, content: CompositeByteBuf(freed, components=1))
//        HTTP/1.1 200 OK
//        Date: Wed, 10 Jul 2019 15:10:41 GMT
//        content-type: application/json
//        content-length: 2
//        connection: close convertedBodies=[Foo foo:Optional[gormdemo.domain.Foo@6daf7d37]] mediaTypeCodecRegistry=io.micronaut.http.codec.DefaultMediaTypeCodecRegistry@23a5818e byteBufferFactory=io.micronaut.buffer.netty.NettyByteBufferFactory@4715ae33 body=gormdemo.domain.Foo@6daf7d37 complete=true>
//
    }
}
