# TINY URL APPLICATION

## USER - Use Cases
- SALVAR USUARIO: 
    POST -> Salva User (nome) -> (nome, id)

## URL MAPPING - Use Cases
- SALVAR TINY URL: 
    POST -> Salva URLMapping (orignal) -> (original, tiny, id, URLInfo)

- RECUPERAR TODAS TINY URL:
    GET -> Recupera todas as TinyURL existentes
    
- RECUPERAR TINY URLs POR USUARIO:
    GET -> Recupera todas as infos de TinyURLs associadas a um usuário (id)
    
- RECUPERAR TINY URL ESPECÍFICA
    GET -> Recupera infos de TinyURL (tiny)

## INFO
- Clean code e estruturado

- Tentativa de seguir ao máximo DDD e SOLID

## STEPS
- Criar um ou mais usuários com o POST 
    /user

- Criar uma ou mais tinyURL com o POST 
    /tinyurl

- Recurar as informações com os GETs
    /tinyurl
    /tinyurl/userid/{id}
    /tinyurl/{sufixo da tinyurl}
    