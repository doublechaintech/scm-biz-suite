

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './ObjectAccess.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')

const pushIfNotNull=(holder,value)=>{
  if(value==null){
    return
  }
  holder.push(value)

}

const overrideValue=(values,defaultValue)=>{
  
  const result = _.findLast(values,it=>!_.isUndefined(it)&&!_.isNull(it))
  if(_.isUndefined(result)){
    return defaultValue
  }
  return result
}


const filterObjectKeys=(targetObject)=>{

  const filteredValues = {}
  for(var key in targetObject){
      const value = targetObject[key]
      if(!value){
        continue
      }
      filteredValues[key] = value
     
  }
  return filteredValues

}

class ObjectAccessSearchForm extends PureComponent {
  state = {
    // addInputValue: '',
    // modalVisible: false,
    expandForm: false,
    // selectedRows: [],
    // formValues: {},
  }
componentDidMount() {
    // const { dispatch } = this.props
    // console.log(this.props)
    // const { getFieldDecorator, setFieldsValue } = this.props.form
    const { setFieldsValue,setFieldValue } = this.props.form
    const { expandForm } = this.props
    
    const { searchFormParameters } = this.props
    if (!searchFormParameters) {
      return
    }
    console.log("searchFormParameters", searchFormParameters)

    setFieldsValue(searchFormParameters)
    if(_.isUndefined(expandForm)){
      this.setState({searchParams:searchFormParameters,expandForm:false})
      return
    }
    this.setState({searchParams:searchFormParameters,expandForm})
    
  }
  toggleForm = () => {
    this.setState({
      expandForm: !this.state.expandForm,
    })
  }
  handleFormReset = () => {
    const { form, dispatch } = this.props
    form.resetFields()
    dispatch({
      type: 'rule/fetch',
      payload: {},
    })
  }
  /*
  buildStringSearchParameters = (formValues, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      console.log('NO VALUE')
      return {}
    }
    return {
      objectAccessList: 1,
      'objectAccessList.searchField': fieldName,
      'objectAccessList.searchVerb': 'startsWith',
      'objectAccessList.searchValue': fieldValue,
    }
  }
  */
  buildStringSearchParameters = (listName, formValues, searchVerb, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      return null
    }
    
    //paramHolder.length
    const value = {}

    value[`${listName}.searchField`] = fieldName
    value[`${listName}.searchVerb`] =  searchVerb
    value[`${listName}.searchValue`] = fieldValue
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
      const { owner } = this.props
      const {listName} = owner
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'name'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'objectType'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list1'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list2'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list3'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list4'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list5'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list6'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list7'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list8'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'list9'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'app'))

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
      
      params[`${listName}`] = 1
      params[`${listName}.orderBy.0`] = "id"
      params[`${listName}.descOrAsc.0`] = "desc"
      
      
      const expandForm = overrideValue([this.state.expandForm],false)
      dispatch({
        type: `${owner.type}/load`,
        payload: { id: owner.id, parameters: params, 
        objectAccessSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
    const {ObjectAccessService} = GlobalComponents
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    const availableForEdit = (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    }
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

       <Col md={8} sm={24}>
         <FormItem label="ID">
           {getFieldDecorator('id')(
             <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label="名称">
           {getFieldDecorator('name')(
             <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button  icon="search" type="primary" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
              <Button  icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> {appLocaleName(userContext,"Expand")} <Icon type="down" /> </a>
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {ObjectAccessService} = GlobalComponents
    const { getFieldDecorator } = this.props.form
    const userContext = null
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    
    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>

          <Col md={8} sm={24}>
            <FormItem label="ID">
              {getFieldDecorator('id')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名称">
              {getFieldDecorator('name')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="访问对象类型">
              {getFieldDecorator('objectType')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表1">
              {getFieldDecorator('list1')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表2">
              {getFieldDecorator('list2')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表3">
              {getFieldDecorator('list3')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表4">
              {getFieldDecorator('list4')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表5">
              {getFieldDecorator('list5')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表6">
              {getFieldDecorator('list6')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表7">
              {getFieldDecorator('list7')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表8">
              {getFieldDecorator('list8')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="列表9">
              {getFieldDecorator('list9')(
                <Input size="large" placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="应用程序">
                  {getFieldDecorator('app', {
                    initialValue: tryinit('app'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('app')}
                    targetType={"app"} 
                    requestFunction={ObjectAccessService.requestCandidateApp}/>
                  
                 
                  )}
                </Form.Item></Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" icon="search" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
            <Button icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>{appLocaleName(userContext,"Collapse")} <Icon type="up" /></a>
          </span>
        </div>
      </Form>
    )
  }

  render() {
  	const expandForm = overrideValue([this.state.expandForm],false)
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm()
  }
}

export default Form.create()(ObjectAccessSearchForm)


