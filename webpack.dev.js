var LiveReloadPlugin = require('webpack-livereload-plugin');

module.exports = {
    context: __dirname + "/src/main/js",
    entry: [
        './index.js'
    ],
    devtool: 'sourcemaps',
    cache: true,
    mode: 'development',
    output: {
        path: __dirname + '/src/main/resources/static/built',
        filename: 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /(node_modules)/,
                use: {
                    loader: "babel-loader",
                    options: {
                        presets: [
                            ['@babel/preset-env', {modules: false}],
                            ['@babel/preset-react', {modules: false}]
                        ]
                    }
                }
            },
            {
                test: /\.css$/,
                exclude: /(node_modules)/,
                use: [
                    {
                        loader: "style-loader"
                    },
                    {
                        loader: "css-loader",
                        options: {
                            modules: true,
                            importLoaders: 1,
                            localIdentName: "[name]_[local]_[hash:base64]",
                            sourceMap: true,
                            minimize: true
                        }
                    }
                ]
            }
        ]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    plugins: [
        new LiveReloadPlugin({
            protocol: "https",
            appendScriptTag: true
        })
    ]
};