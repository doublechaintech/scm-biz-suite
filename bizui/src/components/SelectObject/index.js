import { AutoComplete, Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'

// import G6 from '@antv/g6';
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


export default class Graph extends React.Component {
  state = {
    candidateValues: [],
    
  }

  executeSearch = (filterKey) =>{

    
    const {targetType, requestFunction} = this.props
    const id = "";//not used for now
    const pageNo = 1;
    const future = requestFunction(targetType, id, filterKey, pageNo)
    console.log(future);
    
    

    future.then(data=>{
      const candidateValues = data.candidates
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


  render() {
    

    const {candidateValues,placeholder} = this.state
    const {value,disabled,useForSearch} = this.props
    if(!candidateValues){
      return (<div>正在载入候选项......</div>)
    }
    

    const calcSize=()=>{

      if(useForSearch){
        return "default"
      }
      return "large"

    }

    return (
      <AutoComplete
              value={valueOf(value,candidateValues)}
               size={calcSize()}
                    dataSource={candidateValues.map(item=>{
                      return (<Option key={item.id}>{`${item.id} - ${item.displayName}`}</Option>);
                    })}
                    onSearch={this.handleSearch}
                    placeholder="请选择列表中或者输入搜索"
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
