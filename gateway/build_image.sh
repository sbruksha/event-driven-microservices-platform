DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo -n "Enter Image Tag, or leave blank for 'latest'"
read TAG
if [ -z $TAG ]; then
    TAG="latest"
fi

rm -rf target/*.jar
mvn package spring-boot:repackage

docker build -t eodessa/gateway:$TAG -f $DIR/Dockerfile $DIR
