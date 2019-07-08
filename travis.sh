#!/bin/bash
set -euo pipefail

function installTravisTools {
  mkdir -p ~/.local
  curl -sSL https://github.com/SonarSource/travis-utils/tarball/v55 | tar zx --strip-components 1 -C ~/.local
  source ~/.local/bin/install
}

installTravisTools
. ~/.local/bin/installMaven35

case "$TEST" in

ci)
  export DEPLOY_PULL_REQUEST=true
  regular_mvn_build_deploy_analyze

  ;;

*)
  echo "Unexpected TEST mode: $TEST"
  exit 1
  ;;

esac
