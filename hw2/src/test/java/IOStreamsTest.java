import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.hw2.service.IOServiceStreams;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class IOStreamsTest {

    @Mock
    private PrintStream outputStream;

    @Test
    void testOutput() {
        var is = new ByteArrayInputStream("answer".getBytes(StandardCharsets.UTF_8));
        var strToPrint = "test prompt";
        var ioService = new IOServiceStreams(outputStream, is);
        ioService.printString(strToPrint);
        verify(outputStream, times(1)).println(strToPrint);

    }
    @Test
    public void testReadStringWithPrompt() {
        var is = new ByteArrayInputStream("line1\nline2".getBytes(StandardCharsets.UTF_8));
        var ioService = new IOServiceStreams(outputStream, is);
        Assertions.assertEquals("line1", ioService.readStringWithPrompt("prompt1"));
        Assertions.assertEquals("line2", ioService.readStringWithPrompt("prompt2"));

    }
}
