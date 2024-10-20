package dev.omyshko.datahub;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ContentManagement {

    @SneakyThrows
    public static void main(String[] args) {
        String exampleLLMResponse = Files.readString(Paths.get("src/main/resources/gpt_instructions/content-management/example_response_format.md"));
        new ContentUpdateInstructionProcessor().process(exampleLLMResponse);
    }


    public static class ContentUpdateInstructionProcessor {

        FlexMarkOperationParser operationParser = new FlexMarkOperationParser();

        /**
         * @param text - Raw text LLM response with instructions of file updates
         *             The instructions and expected format can be found in
         *             `resources/content-management/example_response_format.md`
         */
        public void process(String text) {
            List<Operation> operations = parseTextToOperations(text);
            List<OperationResult> list = operations.stream().map(Operation::execute).toList();
            //Create List<Operation>
        }

        private List<Operation> parseTextToOperations(String text) {
            String[] sections = text.split("--");
            Arrays.stream(sections).forEach(operationParser::parse);
            //Бю тест на блоки інструкцій
            //Порсаю кожен блок окремо
            return null;
        }


        private boolean isOperation(String text) {
            return text.contains("Operation:");
        }
    }


    public static class FlexMarkOperationParser {

        Parser parser;

        public FlexMarkOperationParser() {
            MutableDataSet options = new MutableDataSet();
            options.set(Parser.EXTENSIONS, Arrays.asList(StrikethroughExtension.create()));

            parser = Parser.builder(options).build();
        }

        public Operation parse(String section) {

            Node document = parser.parse(section);
            String resource = null, operation = null, contextBefore = null, contextAfter = null, content = null;

            for (Node node : document.getChildren()) {
                Heading heading = (Heading) node;
                log.info(node.toAstString(true));
            }


            return null;
        }
    }

    public record OperationResult() {
    }

    public static abstract class Operation {
        private OperationType type;
        private String path; // todo change to URI

        protected abstract OperationResult execute();
    }

    public static class CreateOperation extends Operation {
        private String content;

        @Override
        protected OperationResult execute() {
            log.error("Not implemented");
            return null;
        }
    }

    public static class UpdateOperation extends Operation {
        private int fromLineNumber;
        private int toLineNumber;
        private String content;

        @Override
        protected OperationResult execute() {
            log.error("Not implemented");
            return null;
        }
    }

    public enum OperationType {
        CREATE, UPDATE, DELETE
    }










/*    public static class NativeOperationParser {
        public Operation parse(String section) {
            String[] lines = section.trim().split("\n");

            for (String line : lines) {
                line = line.trim();
                if (line.startsWith("Resource:")) {
                    fileOperation.setResource(line.substring("Resource:".length()).trim());
                } else if (line.startsWith("Operation:")) {
                    fileOperation.setOperation(line.substring("Operation:".length()).trim());
                } else if (line.startsWith("Context Before {")) {
                    String contextBefore = extractBlockContent(line, lines);
                    fileOperation.setContextBefore(contextBefore);
                } else if (line.startsWith("Context After {")) {
                    String contextAfter = extractBlockContent(line, lines);
                    fileOperation.setContextAfter(contextAfter);
                } else if (line.startsWith("Content {")) {
                    String content = extractBlockContent(line, lines);
                    fileOperation.setContent(content);
                }
            }
        }
    }*/

}
