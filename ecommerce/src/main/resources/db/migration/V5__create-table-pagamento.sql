CREATE TABLE pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    data_pagamento DATETIME DEFAULT CURRENT_TIMESTAMP,
    valor_pago DECIMAL(10, 2) NOT NULL,
    status ENUM('pendente', 'aprovado', 'rejeitado') NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);
