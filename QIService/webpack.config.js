const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
  mode: 'development',
  devtool: 'source-map',
  entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
  devServer: {
    contentBase: './dist',
    compress: true,
    port: 8001,
    allowedHosts: [
      'localhost:8080'
    ],
    stats: 'errors-only',
    clientLogLevel: 'error',
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
      {
        test: /\.(scss)$/,
        use: [{
          loader: 'style-loader', // inject CSS to page
        }, {
          loader: 'css-loader', // translates CSS into CommonJS modules
        }, {
          loader: 'postcss-loader', // Run post css actions
          options: {
            plugins: function () { // post css plugins, can be exported to postcss.config.js
              return [
                require('precss'),
                require('autoprefixer')
              ];
            }
          }
        }, {
          loader: 'sass-loader' // compiles Sass to CSS
        }]
      },
	  {
        test: /\.css$/i,
        use: ['to-string-loader', 'css-loader'],
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
	  {
        test: /\.(png|jpe?g|gif)$/i,
        loader: 'file-loader',
        options: {
          name: '[path][name].[ext]',
      }
	 },
	 {
        test: /\.svg/,
        use: {
          loader: "svg-url-loader",
          options: {}
        }
	 },
	 {
        test: /\.(ttf|otf|eot|woff|woff2)$/,
        use: {
          loader: "file-loader",
          options: {
            name: "fonts/[name].[ext]",
          },
        },
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin()
  ],
  resolve: {
	  extensions: ['*', '.js', '.vue', '.json'],    // <-- line added 
      alias: {
      	'vue$': 'vue/dist/vue.esm.js'
      },
      modules: [
          path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
          path.join(__dirname, 'node_modules'),
      ],
  }
}