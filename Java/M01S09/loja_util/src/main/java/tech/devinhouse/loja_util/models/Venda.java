package tech.devinhouse.loja_util.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "venda")
public class Venda {
    // id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // data_venda DATETIME NOT NULL,
    @Column(name = "data_venda", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataVenda;

    // status_venda VARCHAR(1) NOT NULL,
    @Column(name = "status_venda", length = 1, nullable = false)
    private char statusVenda;

    // quantidade DECIMAL(10,1) UNSIGNED NOT NULL,
    @Column(columnDefinition = "DECIMAL(10,1) UNSIGNED NOT NULL", nullable = false)
    private Double quantidade;

    // valor_total DECIMAL(10,2) UNSIGNED NOT NULL,
    @Column(name = "valor_total", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL", nullable = false)
    private Double valorTotal;

    // cliente_id INT NOT NULL
    // CONSTRAINT fk_venda_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
    @ManyToOne
    //@JoinColumn(name = "cliente_id", nullable = false, insertable=false, updatable=false)
    private Cliente cliente;
}
