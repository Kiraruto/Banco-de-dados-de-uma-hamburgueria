# API Documentation

## Endpoints

---

### `/endereco`

- **Method**: `POST`
- **Summary**: "Criar endereço para usuário."
- **Responses**: 
  - `200`: OK

---

### `/endereco/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar endereço do usuário."
- **Parameters**:
  - `id`: "ID do usuário para atualizar o endereço."
- **Responses**: 
  - `200`: OK

---

### `/itemPedido`

- **Method**: `GET`
- **Summary**: "Ver os itens pedidos."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar os itens pedidos."
- **Responses**: 
  - `200`: OK

---

### `/login`

- **Method**: `POST`
- **Summary**: "Realizar login, disponível apenas para usuários moderadores."
- **Responses**: 
  - `200`: OK

---

### `/pagamento`

- **Method**: `POST`
- **Summary**: "Criar pagamento."
- **Responses**: 
  - `200`: OK

---

### `/pagamento/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar status do pagamento de falso para verdadeiro."
- **Parameters**:
  - `id`: "ID do pagamento a ser atualizado."
- **Responses**: 
  - `200`: OK

---

### `/pedido`

- **Method**: `POST`
- **Summary**: "Criar pedido."
- **Responses**: 
  - `200`: OK

---

### `/pedido/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar pedido."
- **Parameters**:
  - `id`: "ID do pedido a ser atualizado."
- **Responses**: 
  - `200`: OK

- **Method**: `DELETE`
- **Summary**: "Deletar pedido pelo ID."
- **Parameters**:
  - `id`: "ID do pedido a ser deletado."
- **Responses**: 
  - `200`: OK

---

### `/produto`

- **Method**: `GET`
- **Summary**: "Ver todos os produtos."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar produtos."
- **Responses**: 
  - `200`: OK

---

### `/produto/{id}`

- **Method**: `GET`
- **Summary**: "Ver produto pelo ID."
- **Parameters**:
  - `id`: "ID do produto."
- **Responses**: 
  - `200`: OK

- **Method**: `PUT`
- **Summary**: "Atualizar produto."
- **Parameters**:
  - `id`: "ID do produto a ser atualizado."
- **Responses**: 
  - `200`: OK

- **Method**: `DELETE`
- **Summary**: "Deletar produto pelo ID."
- **Parameters**:
  - `id`: "ID do produto a ser deletado."
- **Responses**: 
  - `200`: OK

---

### `/usuario`

- **Method**: `GET`
- **Summary**: "Ver todos os usuários."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar usuários não moderadores."
- **Responses**: 
  - `200`: OK

---

### `/usuario/moderator`

- **Method**: `POST`
- **Summary**: "Criar usuários moderadores."
- **Responses**: 
  - `200`: OK

---

### `/usuario/{id}`

- **Method**: `DELETE`
- **Summary**: "Deletar usuário pelo ID, também deleta o endereço."
- **Parameters**:
  - `id`: "ID do usuário a ser deletado."
- **Responses**: 
  - `200`: OK

---
