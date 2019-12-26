

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './SecUser.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'
<<<<<<< HEAD
=======
import SecUserBase from './SecUser.base'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')
const {fieldLabels} = SecUserBase
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

class SecUserSearchForm extends PureComponent {
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
      secUserList: 1,
      'secUserList.searchField': fieldName,
      'secUserList.searchVerb': 'startsWith',
      'secUserList.searchValue': fieldValue,
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
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'login'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'mobile'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'email'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'pwd'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'weixinOpenid'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'weixinAppid'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'accessToken'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'domain'))
<<<<<<< HEAD
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'currentStatus'))
=======
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'blocking'))
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

     
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
        secUserSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
    const {SecUserService} = GlobalComponents
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
<<<<<<< HEAD
         <FormItem label="ID">
=======
         <FormItem label={fieldLabels.id}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
           {getFieldDecorator('id')(
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label={fieldLabels.login}>
           {getFieldDecorator('login')(
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
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
  	const {SecUserService} = GlobalComponents
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
<<<<<<< HEAD
            <FormItem label="ID">
=======
            <FormItem label={fieldLabels.id}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('id')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.login}>
              {getFieldDecorator('login')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="手机号码">
=======
            <FormItem label={fieldLabels.mobile}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('mobile')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.email}>
              {getFieldDecorator('email')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="密码">
=======
            <FormItem label={fieldLabels.pwd}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('pwd')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="微信openid">
=======
            <FormItem label={fieldLabels.weixinOpenid}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('weixinOpenid')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="微信Appid">
=======
            <FormItem label={fieldLabels.weixinAppid}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('weixinAppid')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="访问令牌">
=======
            <FormItem label={fieldLabels.accessToken}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('accessToken')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
<<<<<<< HEAD
                    <Form.Item label="域">
=======
                    <Form.Item label={fieldLabels.domain}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  {getFieldDecorator('domain', {initialValue: tryinit('domain')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('domain')}
                    targetType={"domain"} 
                    requestFunction={SecUserService.requestCandidateDomain} useForSearch />
                  	
<<<<<<< HEAD
=======
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.blocking}>
                  {getFieldDecorator('blocking', {initialValue: tryinit('blocking')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('blocking')}
                    targetType={"blocking"} 
                    requestFunction={SecUserService.requestCandidateBlocking} useForSearch />
                  	
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                 
                  )}
                </Form.Item></Col>

<<<<<<< HEAD
          <Col md={8} sm={24}>
            <FormItem label="当前状态">
              {getFieldDecorator('currentStatus')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
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

export default Form.create()(SecUserSearchForm)


