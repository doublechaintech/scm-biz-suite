

import React, { PureComponent } from 'react'
import { connect } from 'dva'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd'

import styles from './AccountSet.search.less'
import GlobalComponents from '../../custcomponents'
import SelectObject from '../../components/SelectObject'
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

class AccountSetSearchForm extends PureComponent {
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
      accountSetList: 1,
      'accountSetList.searchField': fieldName,
      'accountSetList.searchVerb': 'startsWith',
      'accountSetList.searchValue': fieldValue,
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

    value[`accountSetList.searchField`] = fieldName
    value[`accountSetList.searchVerb`] =  searchVerb
    value[`accountSetList.searchValue`] = fieldValue
    
    return value

  }
  
  
  
  handleSearch = (e) => {
    e.preventDefault()
    const { dispatch, form } = this.props
    form.validateFields((err, fieldsValue) => {
      if (err) return
      const paramList = []
      
     
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'id'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'name'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'yearSet'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'accountingSystem'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'domesticCurrencyCode'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'domesticCurrencyName'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'openingBank'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'contains', 'accountNumber'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'countryCenter'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'retailStore'))
		pushIfNotNull(paramList,this.buildStringSearchParameters(fieldsValue,'eq', 'goodsSupplier'))

     
      console.log("the final parameter", paramList)
      
      const params = {}
      
     
      for(var i=0;i<paramList.length;i++){
        const element = paramList[i];
        for (var key in element) {
          params[key+"."+i]=element[key]
        }

      }
     
      params['accountSetList'] = 1
      params['accountSetList.orderBy.0'] = "id"
      params['accountSetList.descOrAsc.0'] = "desc"
      
      const { owner } = this.props
      const expandForm = overrideValue([this.state.expandForm],false)
      dispatch({
        type: `${owner.type}/load`,
        payload: { id: owner.id, parameters: params, 
        accountSetSearchFormParameters: filterObjectKeys(fieldsValue),
        searchParameters: params,
        expandForm },
      })
    })
  }
      
  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form
    const {AccountSetService} = GlobalComponents
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
             <Input placeholder="请输入序号" />
           )}
         </FormItem>
       </Col>

       <Col md={8} sm={24}>
         <FormItem label="名称">
           {getFieldDecorator('name')(
             <Input placeholder="请输入名称" />
           )}
         </FormItem>
       </Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button type="primary" htmlType="submit">查询</Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}> 展开 <Icon type="down" /> </a>
            </span>
          </Col>
        </Row>
      </Form>
    )
  }
  renderAdvancedForm() {
  	const {AccountSetService} = GlobalComponents
    const { getFieldDecorator } = this.props.form
    
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
                <Input placeholder="请输入序号" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名称">
              {getFieldDecorator('name')(
                <Input placeholder="请输入名称" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="年组">
              {getFieldDecorator('yearSet')(
                <Input placeholder="请输入年组" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="会计制度">
              {getFieldDecorator('accountingSystem')(
                <Input placeholder="请输入会计制度" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="本币代码">
              {getFieldDecorator('domesticCurrencyCode')(
                <Input placeholder="请输入本币代码" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="本币名称">
              {getFieldDecorator('domesticCurrencyName')(
                <Input placeholder="请输入本币名称" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="开户银行">
              {getFieldDecorator('openingBank')(
                <Input placeholder="请输入开户银行" />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="帐户号码">
              {getFieldDecorator('accountNumber')(
                <Input placeholder="请输入帐户号码" />
              )}
            </FormItem>
          </Col>
 <Col md={8} sm={24}>
                    <Form.Item label="全国运营中心">
                  {getFieldDecorator('countryCenter', {
                    initialValue: tryinit('countryCenter'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('countryCenter')}
                    targetType={"countryCenter"} 
                    requestFunction={AccountSetService.requestCandidateCountryCenter}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="双链小超">
                  {getFieldDecorator('retailStore', {
                    initialValue: tryinit('retailStore'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStore')}
                    targetType={"retailStore"} 
                    requestFunction={AccountSetService.requestCandidateRetailStore}/>
                  
                 
                  )}
                </Form.Item></Col>
 <Col md={8} sm={24}>
                    <Form.Item label="产品供应商">
                  {getFieldDecorator('goodsSupplier', {
                    initialValue: tryinit('goodsSupplier'),
                   
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('goodsSupplier')}
                    targetType={"goodsSupplier"} 
                    requestFunction={AccountSetService.requestCandidateGoodsSupplier}/>
                  
                 
                  )}
                </Form.Item></Col>

        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" htmlType="submit">查询</Button>
            <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>重置</Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>收起 <Icon type="up" /></a>
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

export default Form.create()(AccountSetSearchForm)


