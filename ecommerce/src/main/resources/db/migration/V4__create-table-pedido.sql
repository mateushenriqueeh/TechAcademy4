CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pendente', 'aprovado', 'enviado', 'concluído', 'cancelado') NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    id_forma_pgto INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_forma_pgto) REFERENCES forma_pgto(id_forma_pgto)
);
