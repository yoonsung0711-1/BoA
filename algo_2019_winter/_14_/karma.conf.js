module.exports = function (config) {
  config.set({
    basePath: "",
    frameworks: ["jasmine"],
    files: ["node_modules/es6-shim/es6-shim.js", "dist/*.spec.js"],
    exclude: [],
    preprocessors: {},
    plugins: [
      require("karma-jasmine"),
      require("karma-chrome-launcher"),
      require("karma-phantomjs-launcher"),
      require("karma-spec-reporter"),
      require("karma-jasmine-html-reporter"),
    ],
    reporters: ["spec", "kjhtml"],
    port: 9876,
    colors: true,
    logLevel: config.LOG_DISABLE,
    autoWatch: true,
    browsers: ["PhantomJS"],
    client: {
      clearContext: true,
    },
    singleRun: false,
    concurrency: Infinity,
  });
};
