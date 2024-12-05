package br.ecommercedigital.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_forma_pgto")
public class FormaPgto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pgto")
    private Integer id_forma_pgto;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Integer getId_forma_pgto() {
        return id_forma_pgto;
    }

    public void setId_forma_pgto(Integer id_forma_pgto) {
        this.id_forma_pgto = id_forma_pgto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPgto formaPgto = (FormaPgto) o;
        return id_forma_pgto.equals(formaPgto.id_forma_pgto);
    }

    @Override
    public int hashCode() {
        return id_forma_pgto.hashCode();
    }
}
