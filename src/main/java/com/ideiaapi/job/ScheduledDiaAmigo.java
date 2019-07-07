package com.ideiaapi.job;

import com.ideiaapi.mail.EnvioEmail;
import com.ideiaapi.model.Funcionario;
import com.ideiaapi.repository.FuncionarioRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledDiaAmigo {

    private static String emailPoliciaFederal = "psicologos.deleaq.mg@dpf.gov.br";
    private static String emailIdeia = "clinica.ideia@gmail.com";
    private static String emailNilza = "nilzamarquez5@gmail.com";

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnvioEmail envioEmail;

    /**
     * DIA DO AMIGO
     */
    /***
     * A: Segundos (0 – 59).
     * B: Minutos (0 – 59).
     * C: Horas (0 – 23).
     * D: Dia (1 – 31).
     * E: Mês (1 – 12).
     * F: Dia da semana (0 – 6).
     */
//    @Scheduled(cron = "0 0 6 20 7 *")
//        @Scheduled(fixedDelay = 1)
    public void diaAmigo() {

//        List<Funcionario> funcionarioList = this.funcionarioRepository.findAll();
//
//        funcionarioList.stream()
//                .filter(funcionario -> StringUtils.isNotBlank(funcionario.getEmail()))
//                .forEach(this::enviarEmailDiaAmigo);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Nilza");
//        funcionario.setEmail("alvesdesouzaalex@gmail.com");
        funcionario.setEmail(emailNilza);
        this.enviarEmailDiaAmigo(funcionario);

    }

    private void enviarEmailDiaAmigo(Funcionario funcionario) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", funcionario.getNome());

        this.envioEmail.enviarEmail(emailIdeia,
                Collections.singletonList(funcionario.getEmail()),
                "Feliz Dia do Amigo",
                "email/dia-amigo", map);
    }
}
