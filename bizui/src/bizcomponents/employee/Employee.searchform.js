

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './Employee.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
<<<<<<< HEAD
=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
  buildStringSearchParameters = (formValues, searchVerb, fieldName) => {
=======
  buildStringSearchParameters = (listName, formValues, searchVerb, fieldName) => {
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      return null
    }
    
    //paramHolder.length
    const value = {}

<<<<<<< HEAD
    value[`employeeList.searchField`] = fieldName
    value[`employeeList.searchVerb`] =  searchVerb
    value[`employeeList.searchValue`] = fieldValue
=======
    value[`${listName}.searchField`] = fieldName
    value[`${listName}.searchVerb`] =  searchVerb
    value[`${listName}.searchValue`] = fieldValue
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
<<<<<<< HEAD
      
     
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
=======
      const { owner } = this.props
      const {listName} = owner
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'company'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'title'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'department'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'familyName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'givenName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'email'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'city'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'address'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'cellPhone'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'occupation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'responsibleFor'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'currentSalaryGrade'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'salaryAccount'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'currentStatus'))
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
<<<<<<< HEAD
      params['employeeList'] = 1
      params['employeeList.orderBy.0'] = "id"
      params['employeeList.descOrAsc.0'] = "desc"
      
      const { owner } = this.props
=======
      
      params[`${listName}`] = 1
      params[`${listName}.orderBy.0`] = "id"
      params[`${listName}.descOrAsc.0`] = "desc"
      
      
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
             <Input placeholder="请输入序号" />
=======
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
           )}
         </FormItem>
       </Col>
 <Col md={8} sm={24}>
                 <Form.Item label="公司">
<<<<<<< HEAD
               {getFieldDecorator('company', {
                 initialValue: tryinit('company'),
                
               })(
=======
               {getFieldDecorator('company', {initialValue: tryinit('company')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
               
               <SelectObject 
                 disabled={!availableForEdit('company')}
                 targetType={"company"} 
<<<<<<< HEAD
                 requestFunction={EmployeeService.requestCandidateCompany}/>
               
              
=======
                 requestFunction={EmployeeService.requestCandidateCompany} useForSearch />
               	 
       
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
               )}
             </Form.Item></Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
<<<<<<< HEAD
              <Button type="primary" htmlType="submit">查询</Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> 展开 <Icon type="down" /> </a>
=======
              <Button  icon="search" type="primary" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
              <Button  icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> {appLocaleName(userContext,"Expand")} <Icon type="down" /> </a>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {EmployeeService} = GlobalComponents
    const { getFieldDecorator } = this.props.form
<<<<<<< HEAD
    
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
                <Input placeholder="请输入序号" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="公司">
<<<<<<< HEAD
                  {getFieldDecorator('company', {
                    initialValue: tryinit('company'),
                   
                  })(
=======
                  {getFieldDecorator('company', {initialValue: tryinit('company')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  
                  <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
<<<<<<< HEAD
                    requestFunction={EmployeeService.requestCandidateCompany}/>
                  
=======
                    requestFunction={EmployeeService.requestCandidateCompany} useForSearch />
                  	
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="头衔">
              {getFieldDecorator('title')(
<<<<<<< HEAD
                <Input placeholder="请输入头衔" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="部门">
<<<<<<< HEAD
                  {getFieldDecorator('department', {
                    initialValue: tryinit('department'),
                   
                  })(
=======
                  {getFieldDecorator('department', {initialValue: tryinit('department')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  
                  <SelectObject 
                    disabled={!availableForEdit('department')}
                    targetType={"department"} 
<<<<<<< HEAD
                    requestFunction={EmployeeService.requestCandidateDepartment}/>
                  
=======
                    requestFunction={EmployeeService.requestCandidateDepartment} useForSearch />
                  	
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="姓">
              {getFieldDecorator('familyName')(
<<<<<<< HEAD
                <Input placeholder="请输入姓" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名">
              {getFieldDecorator('givenName')(
<<<<<<< HEAD
                <Input placeholder="请输入名" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="电子邮件">
              {getFieldDecorator('email')(
<<<<<<< HEAD
                <Input placeholder="请输入电子邮件" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="城市">
              {getFieldDecorator('city')(
<<<<<<< HEAD
                <Input placeholder="请输入城市" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="地址">
              {getFieldDecorator('address')(
<<<<<<< HEAD
                <Input placeholder="请输入地址" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="手机">
              {getFieldDecorator('cellPhone')(
<<<<<<< HEAD
                <Input placeholder="请输入手机" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="职业">
<<<<<<< HEAD
                  {getFieldDecorator('occupation', {
                    initialValue: tryinit('occupation'),
                   
                  })(
=======
                  {getFieldDecorator('occupation', {initialValue: tryinit('occupation')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  
                  <SelectObject 
                    disabled={!availableForEdit('occupation')}
                    targetType={"occupation"} 
<<<<<<< HEAD
                    requestFunction={EmployeeService.requestCandidateOccupation}/>
                  
=======
                    requestFunction={EmployeeService.requestCandidateOccupation} useForSearch />
                  	
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="负责">
<<<<<<< HEAD
                  {getFieldDecorator('responsibleFor', {
                    initialValue: tryinit('responsibleFor'),
                   
                  })(
=======
                  {getFieldDecorator('responsibleFor', {initialValue: tryinit('responsibleFor')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  
                  <SelectObject 
                    disabled={!availableForEdit('responsibleFor')}
                    targetType={"responsibleFor"} 
<<<<<<< HEAD
                    requestFunction={EmployeeService.requestCandidateResponsibleFor}/>
                  
=======
                    requestFunction={EmployeeService.requestCandidateResponsibleFor} useForSearch />
                  	
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="目前工资等级">
<<<<<<< HEAD
                  {getFieldDecorator('currentSalaryGrade', {
                    initialValue: tryinit('currentSalaryGrade'),
                   
                  })(
=======
                  {getFieldDecorator('currentSalaryGrade', {initialValue: tryinit('currentSalaryGrade')})(
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  
                  <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
<<<<<<< HEAD
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade}/>
                  
=======
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade} useForSearch />
                  	
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label="工资账户">
              {getFieldDecorator('salaryAccount')(
<<<<<<< HEAD
                <Input placeholder="请输入工资账户" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="当前状态">
              {getFieldDecorator('currentStatus')(
<<<<<<< HEAD
                <Input placeholder="请输入当前状态" />
=======
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
              )}
            </FormItem>
          </Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
<<<<<<< HEAD
            <Button type="primary" htmlType="submit">查询</Button>
            <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>收起 <Icon type="up" /></a>
=======
            <Button type="primary" icon="search" htmlType="submit">{appLocaleName(userContext,"Search")}</Button>
            <Button icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>{appLocaleName(userContext,"Reset")}</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>{appLocaleName(userContext,"Collapse")} <Icon type="up" /></a>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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


