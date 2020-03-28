package sci.category.certify.repo.util

class SqlWork{

    final static def LIST_USERS = """
        select usesysid as user_id,
               usename as username,
               usesuper as is_superuser,
               passwd as password_md5,
               valuntil as password_expiration
        from pg_shadow
        order by usename;
"""
    final static def LIST_USERS_PASSWORD = """
        select passwd as password_md5,
        from pg_shadow
        order by usename;
"""
}
