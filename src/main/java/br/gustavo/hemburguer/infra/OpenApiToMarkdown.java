package br.gustavo.hemburguer.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

import java.io.FileWriter;
import java.io.IOException;

public class OpenApiToMarkdown {

    public static void main(String[] args) {
        SwaggerParseResult result = new OpenAPIV3Parser().readLocation("http://localhost:8080/v3/api-docs", null, null);
        OpenAPI openAPI = result.getOpenAPI();

        if (openAPI == null) {
            System.out.println("Erro ao carregar a especificação OpenAPI.");
            return;
        }

        String markdown = convertOpenApiToMarkdown(openAPI);

        try (FileWriter fileWriter = new FileWriter("api-documentation.md")) {
            fileWriter.write(markdown);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Documentação gerada com sucesso!");
    }

    private static String convertOpenApiToMarkdown(OpenAPI openAPI) {
        StringBuilder markdown = new StringBuilder();

        markdown.append("# API Documentation\n\n");

        if (openAPI.getInfo() != null) {
            markdown.append("## ").append(openAPI.getInfo().getTitle()).append("\n\n");
            markdown.append(openAPI.getInfo().getDescription()).append("\n\n");
        }

        openAPI.getPaths().forEach((path, pathItem) -> {
            markdown.append("### Endpoint: `").append(path).append("`\n\n");

            pathItem.readOperationsMap().forEach((httpMethod, operation) -> {
                markdown.append("- **Method**: `").append(httpMethod.toString().toUpperCase()).append("`\n");
                markdown.append("- **Summary**: ").append(operation.getSummary()).append("\n\n");

                if (operation.getParameters() != null && !operation.getParameters().isEmpty()) {
                    markdown.append("#### Parameters:\n");
                    operation.getParameters().forEach(parameter -> {
                        markdown.append("- `").append(parameter.getName()).append("`: ")
                                .append(parameter.getDescription()).append("\n");
                    });
                    markdown.append("\n");
                }

                markdown.append("#### Responses:\n");
                operation.getResponses().forEach((code, apiResponse) -> {
                    markdown.append("- `").append(code).append("`: ")
                            .append(apiResponse.getDescription()).append("\n");
                });
                markdown.append("\n");
            });

            markdown.append("---\n\n");
        });

        return markdown.toString();
    }
}
