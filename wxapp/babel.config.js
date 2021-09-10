// babel-preset-taro 更多选项和默认值：
// https://github.com/NervJS/taro/blob/next/packages/babel-preset-taro/README.md

const plugins = ['lodash']

const presets = [
  ['taro', {
    framework: 'react',
    ts: true,
  }],
]

if (process.env.NODE_ENV === 'production') {
  plugins.push('transform-remove-console')
}

module.exports = {
  sourceMap: true,
  plugins,
  presets,
}
