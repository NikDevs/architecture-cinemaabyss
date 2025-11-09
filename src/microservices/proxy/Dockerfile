FROM kong:3

USER root

# Устанавливаем bash и envsubst (gettext-base)
RUN apt-get update && apt-get install -y --no-install-recommends \
    bash gettext-base \
    && rm -rf /var/lib/apt/lists/*

# Создаем директорию для declarative.yml
RUN mkdir -p /kong/declarative

# Помещаем шаблон declarative файла
COPY declarative.yml.tmpl /kong/declarative/declarative.yml.tmpl

# Скрипт entrypoint для генерации declarative.yml перед стартом Kong
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENV KONG_DATABASE=off
ENV KONG_DECLARATIVE_CONFIG=/kong/declarative/declarative.yml

ENTRYPOINT ["/entrypoint.sh"]
CMD ["/bin/bash", "-c", "kong start --vv && tail -f /usr/local/kong/logs/*.log"]