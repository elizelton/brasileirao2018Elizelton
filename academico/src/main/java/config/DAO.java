package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.*;

public class DAO {

    private static final AnnotationConfigApplicationContext ctx
            = new AnnotationConfigApplicationContext(DBConfig.class);
    public static DisciplinaRepository disciplinaRepository = ctx.getBean(DisciplinaRepository.class);
    public static ProfessorRepository professorRepository = ctx.getBean(ProfessorRepository.class);
    public static UnidadeFederacaoRepository unidadeFederacaoRepository = ctx.getBean(UnidadeFederacaoRepository.class);
    public static CidadeRepository cidade = ctx.getBean(CidadeRepository.class);
//     public static AlunoRepository alunoRepository = ctx.getBean(AlunoRepository.class);

//    public static NotasRepository notasRepository = ctx.getBean(NotasRepository.class);
//    public static AlunoRepository alunoRepository = ctx.getBean(AlunoRepository.class);
}
