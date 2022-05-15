FROM node:16.14.2-alpine3.15

WORKDIR /app

RUN npm install -g npm@7.11.2

RUN ls -lrta

RUN pwd

COPY ./ui/*.json ./

COPY ./ui/*.js ./

COPY ./ui/*.ts ./

RUN npm install

COPY ./ui/src ./

EXPOSE 3000

RUN npm run build

ENTRYPOINT [ "npm", "run" ]

CMD [ "start"]