import React from 'react';

import RichEditor from '../../components/RichEditor';

class RichTextInput extends React.Component {
  componentDidMount() {
    this._isMounted = true;
  }
  componentWillUnmount() {
    this._isMounted = false;
  }

  handleEditorChange = currentValue => {
    if (!this._isMounted) {
      return;
    }

    console.log('current value', currentValue);
    const value = currentValue;

    if (!('value' in this.props)) {
      // this.setState({ value: currentValue });
    }

    const { onChange } = this.props;

    console.log('onChange value', onChange);
    if (onChange) {
      onChange(currentValue);
    }

    console.log('handleEditorChange', currentValue);
  };

  render() {
    // const { collapsed, fetchingNotices,loading } = this.props
    console.log('In the RICHTEXTINPUT component');

    return (
      <RichEditor
        apiKey="r3lgalooz3dady4ma2yyqqop3pg722okrj3mx95pkxj8ewhj"
        height={800}
        placeholder="请输入内容"
        readonly={true}
        onEditorChange={this.handleEditorChange}
      />
    );
  }
}

export default RichTextInput;
