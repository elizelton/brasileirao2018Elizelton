package repository;

import model.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CidadeRepository extends MongoRepository<Cidade, String> {

}
