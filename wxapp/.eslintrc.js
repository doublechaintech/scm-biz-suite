module.exports = {
  parser: "@typescript-eslint/parser", // Specifies the ESLint parser
  extends: [
    "taro/react",
  ],
  "rules": {
    "import/first": "off",
    "jsx-quotes": "off",
    "react/sort-comp": [0],
    "react/jsx-uses-react": "off",
    "react/react-in-jsx-scope": "off",
    "no-shadow": "off"
  }
}
