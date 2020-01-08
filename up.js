const { execSync } = require("child_process");
const stamp = `${new Date().toLocaleDateString()} ${new Date().toLocaleTimeString()}`;
const command = `git pull && git add . && git commit -m "commonjs快速提交=>${stamp}" && git push -u origin master`;
execSync(command);
