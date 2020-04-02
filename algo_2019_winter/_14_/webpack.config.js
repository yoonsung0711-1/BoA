const path = require("path");
module.exports = {
  entry: {
    test: "./index.spec.ts",
  },
  output: {
    filename: "[name].spec.js",
    path: path.resolve(__dirname, "dist"),
  },
  module: {
    rules: [{ test: /\.tsx?$/, loader: "ts-loader", exclude: /node_modules/ }],
  },
  resolve: {
    extensions: [".tsx", ".ts", ".js", ".json"],
  },
  optimization: {
    minimize: false,
  },
  target: "web",
  stats: "errors-only",
};
