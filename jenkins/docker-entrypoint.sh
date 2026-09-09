#!/bin/bash

if [ -S /var/run/docker.sock ]; then
    DOCKER_GID=$(stat -c '%g' /var/run/docker.sock)

    if ! getent group "$DOCKER_GID" > /dev/null 2>&1; then
        groupadd -g "$DOCKER_GID" docker-host
    fi

    usermod -aG "$DOCKER_GID" jenkins
fi

exec su -s /bin/bash jenkins -c "/usr/bin/tini -- /usr/local/bin/jenkins.sh"
