import { Input, Select,Tooltip } from 'antd';
import React from 'react'
import styles from './index.less';
const { Option } = Select;

const calcStyle=({value, minLength, maxLength})=>{

  if(!value){
    return styles.normal
  }
  if(value.length<minLength){
      return styles.tooShort
  }
  if(value.length>maxLength){
    return styles.tooLong
  }
  return styles.normal

}
const calcTips=({value, minLength, maxLength})=>{
  if(!value){
      return null;
  }
  if((!value||value.length===0)&&minLength===0){
    return <span className={calcStyle({value, minLength, maxLength})}>可选，最多可以输入{maxLength}字</span>
  }
  if(value.length<minLength&&(!value||value.length===0)){
    return <span className={calcStyle({value, minLength, maxLength})}>这是必填字段，需要{minLength}-{maxLength}字</span>
  }
  if(value.length<minLength){
      return <span className={calcStyle({value, minLength, maxLength})}>输入太短了，还需要{minLength-value.length}字</span>
  }
  if(value.length>maxLength){
    return <span className={calcStyle({value, minLength, maxLength})}>输入太长了，多了 {value.length-maxLength}字</span>
  }
  return <span className={calcStyle({value, minLength, maxLength})}>可以输入{maxLength}字</span>

}
export default class SmallTextInput extends React.Component {
  /*
  constructor(props) {
    super(props);

    
    this.state = {
      previewVisible: false,
      previewImage: value,
      fileList: [],
      url: value,
      token: {},
    };
  }*/


  handleTextChange = e => {
    const changedValue = e.target.value;
    e.preventDefault();
    
    console.log("handleTextChange value",changedValue);
    this.triggerChange( changedValue );
  };

  triggerChange = changedValue => {
    const { onChange, value } = this.props;
    if (onChange) {
      onChange(changedValue);
    }
  };

  render() {
    const { size, value, maxLength, minLength } = this.props;
    console.log("value",value)



    return (
      <Tooltip style={{backgroundColor:"white"}}trigger={['focus','hover','click']} placement="topLeft" title={calcTips({value,minLength,maxLength})}>
        <Input
          type="text"
          size={size}
          value={value}
          onChange={this.handleTextChange}
         
        />
        
       </Tooltip>
    );
  }
}

