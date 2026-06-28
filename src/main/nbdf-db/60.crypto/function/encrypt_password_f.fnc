create or replace noneditionable function encrypt_password_f(p_value varchar2)
return varchar2
is
    v_hash varchar2(128);
begin
    select standard_hash(p_value, 'SHA256')
      into v_hash
      from dual;
      
    return v_hash;
end;
/
