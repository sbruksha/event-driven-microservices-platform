FROM nginx
ADD default.conf /etc/nginx/conf.d/default.conf

RUN mkdir -p /etc/nginx/html
ADD index.html /etc/nginx/html/index.html

RUN apt-get update -y && apt-get install -y netcat

COPY entrypoint.sh /tmp/entrypoint.sh
RUN chmod +x /tmp/entrypoint.sh

CMD [ "sh", "-c", "/tmp/entrypoint.sh" ]