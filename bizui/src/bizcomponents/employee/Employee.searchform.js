

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './Employee.search.less'
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

class EmployeeSearchForm extends PureComponent {
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
      employeeList: 1,
      'employeeList.searchField': fieldName,
      'employeeList.searchVerb': 'startsWith',
      'employeeList.searchValue': fieldValue,
    }
  }
  */
  buildStringSearchParameters = (formValues, searchVerb, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      return null
    }
    
    //paramHolder.length
    const value = {}

    value[`employeeList.searchField`] = fieldName
    value[`employeeList.searchVerb`] =  searchVerb
    value[`employeeList.searchValue`] = fieldValue
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
      
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'company'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'title'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'department'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'familyName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'givenName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'email'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'city'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'address'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'cellPhone'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'occupation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'responsibleFor'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'currentSalaryGrade'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'salaryAccount'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'currentStatus'))

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
      params['employeeList'] = 1
      params['employeeList.orderBy.0'] = "id"
      params['employeeList.descOrAsc.0'] = "desc"
      
      const { owner } = this.props
      const expandForm = overrideValue([this.state.expandForm],false)
      dispatch({
        type: `${owner.type}/load`,
        payload: { id: owner.id, parameters: params, 
        employeeSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
    const {EmployeeService} = GlobalComponents
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
         <FormItem label="序号">
           {getFieldDecorator('id')(
             <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>
 <Col md={8} sm={24}>
                 <Form.Item label="公司">
               {getFieldDecorator('company', {
                 initialValue: tryinit('company'),
                
               })(
               
               <SelectObject 
                 disabled={!availableForEdit('company')}
                 targetType={"company"} 
                 requestFunction={EmployeeService.requestCandidateCompany}/>
               
              
               )}
             </Form.Item></Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button type="primary" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> {appLocaleName(userContext,"Expand")} <Icon type="down" /> </a>
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {EmployeeService} = GlobalComponents
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
            <FormItem label="序号">
              {getFieldDecorator('id')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="公司">
                  {getFieldDecorator('company', {
                    initialValue: tryinit('company'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
                    requestFunction={EmployeeService.requestCandidateCompany}/>
                  
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="头衔">
              {getFieldDecorator('title')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="部门">
                  {getFieldDecorator('department', {
                    initialValue: tryinit('department'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('department')}
                    targetType={"department"} 
                    requestFunction={EmployeeService.requestCandidateDepartment}/>
                  
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="姓">
              {getFieldDecorator('familyName')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名">
              {getFieldDecorator('givenName')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="电子邮件">
              {getFieldDecorator('email')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="城市">
              {getFieldDecorator('city')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="地址">
              {getFieldDecorator('address')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="手机">
              {getFieldDecorator('cellPhone')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="职业">
                  {getFieldDecorator('occupation', {
                    initialValue: tryinit('occupation'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('occupation')}
                    targetType={"occupation"} 
                    requestFunction={EmployeeService.requestCandidateOccupation}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="负责">
                  {getFieldDecorator('responsibleFor', {
                    initialValue: tryinit('responsibleFor'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('responsibleFor')}
                    targetType={"responsibleFor"} 
                    requestFunction={EmployeeService.requestCandidateResponsibleFor}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="目前工资等级">
                  {getFieldDecorator('currentSalaryGrade', {
                    initialValue: tryinit('currentSalaryGrade'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade}/>
                  
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="工资账户">
              {getFieldDecorator('salaryAccount')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="当前状态">
              {getFieldDecorator('currentStatus')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
            <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
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

export default Form.create()(EmployeeSearchForm)


