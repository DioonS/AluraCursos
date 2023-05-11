package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "Campo nome obrigatório")
        String nome,
        @NotBlank(message = "Campo email obrigatório")
        @Email(message = "Formato de email inválido")
        String email,
        @NotBlank(message = "Campo telefone obrigatório")
        String telefone,
        @NotBlank(message = "Campo CRM obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull(message = "Campo especialidade obrigatório")
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
