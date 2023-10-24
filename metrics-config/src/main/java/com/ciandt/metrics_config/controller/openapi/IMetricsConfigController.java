package com.ciandt.metrics_config.controller.openapi;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import com.ciandt.metrics_config.request.MetricConfigRequest;
import com.ciandt.metrics_config.response.MetricConfigResponse;
import com.ciandt.metrics_config.response.ResponseErroPadrao;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(tags = "Validação da autorização de uma transação de entrada")
public interface IMetricsConfigController {

        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Retorno com o resultado da tentativa de criar uma nova configuração de métrica", content = @Content(schema = @Schema(implementation = MetricConfigResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Request inválido.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class))),
                        @ApiResponse(responseCode = "500", description = "Erro inesperado durante o processamento.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class)))
        })
        @Operation(summary = "Cria uma nova configuração de métrica")
        public ResponseEntity<MetricConfigResponse> novaMetrica(
                        @RequestBody(required = true, description = "Dados da nova configuração de métrica") MetricConfigRequest request);

        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Retorno com uma lista de métricas encontradas", content = @Content(schema = @Schema(implementation = MetricConfigResponse[].class))),
                        @ApiResponse(responseCode = "204", description = "Nenhuma configuração de métrica encontrada", ref = "[]"),
                        @ApiResponse(responseCode = "400", description = "Request inválido.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class))),
                        @ApiResponse(responseCode = "500", description = "Erro inesperado durante o processamento.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class)))
        })
        @Operation(summary = "Consulta as configurações de métricas existentes")
        public ResponseEntity<List<MetricConfigResponse>> metricas();

        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Configuração de métrica editada", content = @Content(schema = @Schema(implementation = MetricConfigResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Configuração de métrica não encontrada", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class))),
                        @ApiResponse(responseCode = "400", description = "Request inválido.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class))),
                        @ApiResponse(responseCode = "500", description = "Erro inesperado durante o processamento.", content = @Content(schema = @Schema(implementation = ResponseErroPadrao.class)))
        })
        @Operation(summary = "Edita uma métrica existente")
        public ResponseEntity<MetricConfigResponse> editarMetrica(
                        @Parameter(name = "provider") @NotEmpty String provider,
                        @RequestBody(required = true, description = "Dados configuração de métrica") MetricConfigRequest request)
                        throws NotFoundException;

}
