CREATE TABLE public.certstore (
	id bigserial,
	cert text,
    CONSTRAINT server_key PRIMARY KEY (id)
)