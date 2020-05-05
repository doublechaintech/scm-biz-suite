import React, { Component } from 'react';
import { AutoComplete, TreeSelect,Cascader,Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import BaseTool from '../../common/Base.tool'

const { genTree,hasTreeNodes } = BaseTool

const { Option } = Select
const valueOf = (value, candidateValues)=>{
  if(value&&value.length!=0){
    return value
  }
  
  if(candidateValues.length==1){
    return candidateValues[0].id
  }
  return null
}


export default class CandidateList extends React.Component {
  state = {
    candidateValues: [],
    
  }

  executeSearch = (filterKey) =>{

    // const {value,disabled,useForSearch,targetType,groupBy,scenarioCode,ownerType,ownerId} = this.props
    
    
    const {requestFunction,ownerType,ownerId,listType,targetType,groupBy,scenarioCode} = this.props
    const requestData={ownerType,ownerId,listType,targetType,groupBy,scenarioCode}
    const future = requestFunction(requestData)
    console.log(requestData);
    
    

    future.then(data=>{
      const candidateValues = data
      if(this._isMounted){
        const value=valueOf(this.props.value,candidateValues)
        const onChange = this.props.onChange;
        if (onChange) {
          onChange(value);
        }
        this.setState({
        candidateValues,value
      })}

    })

  }	 
  handleSearch = (value) => {
    this.executeSearch(value)
  }

  componentDidMount() {
    this._isMounted = true
    this.executeSearch("")
  }
  componentWillUnmount() {
    this._isMounted = false;
  }
  componentWillReceiveProps(nextProps) {
    // Should be a controlled component.
    if(!this._isMounted){
      return 
    }
    if ('value' in nextProps) {
      const value = nextProps.value;


      this.setState({value});
    }
  }

  handleChange = (currentValue) => {
    if(!this._isMounted){
      return 
    }

    console.log("current value", currentValue)
    const value = currentValue
    
    if (!('value' in this.props)) {
      this.setState({ value });
    }

    const onChange = this.props.onChange;
    if (onChange) {
      onChange(value);
    }
  }

/*
<CandidateList 
                 disabled={!availableForEdit('status')}
                 targetType={"status"} 
                 groupBy={"group_name"}
                 scenarioCode={"search"}
                 ownerType={"platform"}
                 ownerId={"P000001"}
                 
                 requestFunction={DataAppUserService.queryCandidatesForSearch} useForSearch />
               	
*/
  render() {
    

    const {candidateValues,placeholder} = this.state
    const {value,disabled,useForSearch,targetType,groupBy,scenarioCode,ownerType,ownerId} = this.props

    const finalPlaceholder = placeholder || "请选择列表中或者输入搜索"
    if(!candidateValues){
      return (<div>正在载入候选项......</div>)
    }
    


    const calcSize=()=>{

      if(useForSearch){
        return "default"
      }
      return "large"

    }
    
    if(hasTreeNodes(candidateValues)){
      // TreeSelect <Cascader options={options} onChange={onChange}
      // Cascader 还是不正常传递回去一个数组，
      return (
        <TreeSelect
          style={{ width: '100%' }}
          value={valueOf(value,candidateValues)}
          dropdownStyle={{ maxHeight: 400, overflow: 'auto' }}
          treeData={genTree(candidateValues,'')}
          options={genTree(candidateValues,'')}
          placeholder={finalPlaceholder}
          treeDefaultExpandAll
          size={calcSize()}
          onChange={(v)=>this.handleChange(v)}
        />
      );
    }



   

    return (
      <AutoComplete
              value={valueOf(value,candidateValues)}
               size={calcSize()}
                    dataSource={candidateValues.map(item=>{
                      return (<Option key={item.id}>{`${item.name}(${item.id})`}</Option>);
                    })}
                    onSearch={this.handleSearch}
                    placeholder={finalPlaceholder}
                    disabled={disabled}
                    onChange={(value)=>this.handleChange(value)}
                    // eslint-disable-next-line react/react-in-jsx-scope
                    suffix={<Icon type="search" />} 
                  >
                  <Input suffix={( <Icon type="bars" /> )}
          />
          
      </AutoComplete>
    )
  }
}