package pt.iade.api.repository;

import pt.iade.api.models.equipamentos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface QueryRepository extends CrudRepository<equipamentos, Integer> {


    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where marca = :marca", nativeQuery = true)
    Iterable<String> equipamentobymarca(String marca);


    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where tipo = :tipo", nativeQuery = true)
    Iterable<String> equipamentobytipo(String tipo);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where nome = :nome", nativeQuery = true)
    Iterable<String> equipamentobynome(String nome);


    //ordenado

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where marca = :marca ORDER BY marca.marca", nativeQuery = true)
    Iterable<String> equipamentobymarcaORD(String marca);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where tipo = :tipo ORDER BY tipo.tipo", nativeQuery = true)
    Iterable<String> equipamentobytipoORD(String tipo);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where nome = :nome ORDER BY equipamentos.nome", nativeQuery = true)
    Iterable<String> equipamentobynomeORD(String nome);


    //by id


    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where marca.id_marca = :id", nativeQuery = true)
    Iterable<String> equipamentobymarcaid(int id);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where tipo.id_tipo = :id", nativeQuery = true)
    Iterable<String> equipamentobytipoid(int id);


    //ordenado

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where marca.id_marca = :id ORDER BY marca.marca", nativeQuery = true)
    Iterable<String> equipamentobymarcaidORD(int id);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where tipo.id_tipo = :id ORDER BY tipo.tipo", nativeQuery = true)
    Iterable<String> equipamentobytipoidORD(int id);

    @Query(value = "select id_equipamentos,nome,quantidade,marca,tipo,descricao from equipamentos inner join marca on marca.id_marca = equipamentos.id_marca inner join tipo on tipo.id_tipo = equipamentos.id_tipo where id_equipamentos = :id ORDER BY equipamentos.nome", nativeQuery = true)
    Iterable<String> equipamentobyidORD(int id);



    @Query(value = "select * from equipamentos inner join equipamento_acontecimentos on equipamento_acontecimentos.id_equipamentos = equipamentos.id_equipamentos inner join tipo_acontecimento on tipo_acontecimento.id_tipo_acontecimento = equipamento_acontecimentos.id_tipo_acontecimento inner join acontecimentos on acontecimentos.id_acontecimentos = equipamento_acontecimentos.id_acontecimentos where tipo_acontecimento = :tipo_acontecimento", nativeQuery = true)
    Iterable<String> acontecimento(String tipo_acontecimento);








}