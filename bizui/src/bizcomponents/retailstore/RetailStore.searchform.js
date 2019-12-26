

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './RetailStore.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'
<<<<<<< HEAD
=======
import RetailStoreBase from './RetailStore.base'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const FormItem = Form.Item
const { Option } = Select
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',')
const {fieldLabels} = RetailStoreBase
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

class RetailStoreSearchForm extends PureComponent {
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
      retailStoreList: 1,
      'retailStoreList.searchField': fieldName,
      'retailStoreList.searchVerb': 'startsWith',
      'retailStoreList.searchValue': fieldValue,
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
<<<<<<< HEAD
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'telephone'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'owner'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'retailStoreCountryCenter'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'cityServiceCenter'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'description'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'currentStatus'))
=======
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'owner'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'retailStoreCountryCenter'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'cityServiceCenter'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'creation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'investmentInvitation'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'franchising'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'decoration'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'opening'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'eq', 'closing'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(listName, fieldsValue,'contains', 'description'))
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
        retailStoreSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const userContext = null
    const {RetailStoreService} = GlobalComponents
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
         <FormItem label={fieldLabels.id}>
           {getFieldDecorator('id')(
             <Input size="default" placeholder={appLocaleName(userContext,"PleaseInput")} />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label={fieldLabels.name}>
           {getFieldDecorator('name')(
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
  	const {RetailStoreService} = GlobalComponents
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
            <FormItem label={fieldLabels.id}>
              {getFieldDecorator('id')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.name}>
              {getFieldDecorator('name')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
<<<<<<< HEAD
            <FormItem label="电话">
              {getFieldDecorator('telephone')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="业主">
=======
            <FormItem label={fieldLabels.owner}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              {getFieldDecorator('owner')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
<<<<<<< HEAD
                    <Form.Item label="双链小超全国运营中心">
=======
                    <Form.Item label={fieldLabels.retailStoreCountryCenter}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  {getFieldDecorator('retailStoreCountryCenter', {initialValue: tryinit('retailStoreCountryCenter')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStoreCountryCenter')}
                    targetType={"retailStoreCountryCenter"} 
                    requestFunction={RetailStoreService.requestCandidateRetailStoreCountryCenter} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
<<<<<<< HEAD
                    <Form.Item label="城市服务中心">
=======
                    <Form.Item label={fieldLabels.cityServiceCenter}>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  {getFieldDecorator('cityServiceCenter', {initialValue: tryinit('cityServiceCenter')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('cityServiceCenter')}
                    targetType={"cityServiceCenter"} 
                    requestFunction={RetailStoreService.requestCandidateCityServiceCenter} useForSearch />
                  	
<<<<<<< HEAD
=======
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.creation}>
                  {getFieldDecorator('creation', {initialValue: tryinit('creation')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('creation')}
                    targetType={"creation"} 
                    requestFunction={RetailStoreService.requestCandidateCreation} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.investmentInvitation}>
                  {getFieldDecorator('investmentInvitation', {initialValue: tryinit('investmentInvitation')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('investmentInvitation')}
                    targetType={"investmentInvitation"} 
                    requestFunction={RetailStoreService.requestCandidateInvestmentInvitation} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.franchising}>
                  {getFieldDecorator('franchising', {initialValue: tryinit('franchising')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('franchising')}
                    targetType={"franchising"} 
                    requestFunction={RetailStoreService.requestCandidateFranchising} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.decoration}>
                  {getFieldDecorator('decoration', {initialValue: tryinit('decoration')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('decoration')}
                    targetType={"decoration"} 
                    requestFunction={RetailStoreService.requestCandidateDecoration} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.opening}>
                  {getFieldDecorator('opening', {initialValue: tryinit('opening')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('opening')}
                    targetType={"opening"} 
                    requestFunction={RetailStoreService.requestCandidateOpening} useForSearch />
                  	
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label={fieldLabels.closing}>
                  {getFieldDecorator('closing', {initialValue: tryinit('closing')})(
                  
                  <SelectObject 
                    disabled={!availableForEdit('closing')}
                    targetType={"closing"} 
                    requestFunction={RetailStoreService.requestCandidateClosing} useForSearch />
                  	
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                 
                  )}
                </Form.Item></Col>

          <Col md={8} sm={24}>
            <FormItem label={fieldLabels.description}>
              {getFieldDecorator('description')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
<<<<<<< HEAD
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="当前状态">
              {getFieldDecorator('currentStatus')(
                <Input placeholder={appLocaleName(userContext,"PleaseInput")} />
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
              )}
            </FormItem>
          </Col>

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

export default Form.create()(RetailStoreSearchForm)


