import com.iskportal.dedukt.lsp.method.io.request.Request
import com.iskportal.dedukt.lsp.method.io.response.Response
import com.iskportal.dedukt.lsp.rpc.DecodeMessage
import com.iskportal.dedukt.lsp.rpc.EncodeMessage
import kotlin.test.Test
import kotlin.test.assertTrue

class TestEncodeAndDecode {
    val message = Response(jsonrpc = "2.0", id = 1)

    @Test
    fun `jsonRpc Serialization`() {
//        val json = Json { encodeDefaults = true }
//        println(json.encodeToJsonElement<JsonRpc>(message).toString())
    }

    @Test
    fun `encoding a message`() {
        val expectedLength = 51
        val expectedMessage = "Content-Length: $expectedLength\r\n\r\n{\"jsonrpc\":\"2.0\",\"id\":1,\"result\":null,\"error\":null}"

        val encodedMessage = EncodeMessage(message)
        assertTrue {
            encodedMessage.length == expectedLength
        }
        assertTrue {
            expectedMessage == encodedMessage.get()
        }
    }

    @Test
    fun `decoding a message`() {
        val incomingMessage = "Content-Length: 53\r\n\r\n{\"jsonrpc\":\"2.0\",\"method\":\"his\",\"id\":1,\"params\":null}"
        val decodedMessage = DecodeMessage(incomingMessage.toByteArray())
        assertTrue {
            decodedMessage.json == Request(jsonrpc = "2.0", id = 1, method = "his", params = null)
        }
        assertTrue {
            decodedMessage.contentLength == 53
        }
        assertTrue {
            decodedMessage.json.method == "his" && decodedMessage.json.id == 1 && decodedMessage.json.jsonrpc == "2.0"
        }
    }

}