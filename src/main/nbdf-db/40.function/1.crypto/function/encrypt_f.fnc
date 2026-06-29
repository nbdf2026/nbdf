create or replace noneditionable function nsys.encrypt_f(p_value varchar2)
return varchar2
is
    l_key raw(32);
    l_enc raw(2000);

    l_type pls_integer :=
          dbms_crypto.encrypt_aes256
        + dbms_crypto.chain_cbc
        + dbms_crypto.pad_pkcs5;
begin
    l_key := utl_i18n.string_to_raw
             ('12345678901234567890123456789012'
             ,'AL32UTF8'
             );

    l_enc := dbms_crypto.encrypt
             (src => utl_i18n.string_to_raw(p_value, 'AL32UTF8')
             ,typ => l_type
             ,key => l_key
             );

    return rawtohex(l_enc);
end;
/
