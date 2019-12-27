import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './AccountSet.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import AccountSetBase from './AccountSet.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = AccountSetBase
const testValues = {};
/*
const testValues = {
  name: '账套2017',
  yearSet: '2017年',
  effectiveDate: '2019-03-09',
  accountingSystem: '企业会计制度',
  domesticCurrencyCode: 'RMB',
  domesticCurrencyName: '人民币',
  openingBank: '招商银行',
  accountNumber: '3326 5805 0548 85',
  countryCenterId: 'RSCC000001',
  retailStoreId: 'RS000001',
  goodsSupplierId: 'GS000001',
}
*/

const imageKeys = [
]


class AccountSetCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
	
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    
    const {AccountSetService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      if(!owner){
      	return null
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      if(!owner){
      	return true
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
	const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {

      labelCol: { span: 6 },
      wrapperCol: { span: 12 },

    }
    
    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('account_set')}</div>)
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.name} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.yearSet} {...formItemLayout}>
                  {getFieldDecorator('yearSet', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.yearSet} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.effectiveDate} {...formItemLayout}>
                  {getFieldDecorator('effectiveDate', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.effectiveDate}/>
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountingSystem} {...formItemLayout}>
                  {getFieldDecorator('accountingSystem', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.accountingSystem} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.domesticCurrencyCode} {...formItemLayout}>
                  {getFieldDecorator('domesticCurrencyCode', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.domesticCurrencyCode} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.domesticCurrencyName} {...formItemLayout}>
                  {getFieldDecorator('domesticCurrencyName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.domesticCurrencyName} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.openingBank} {...formItemLayout}>
                  {getFieldDecorator('openingBank', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.openingBank} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountNumber} {...formItemLayout}>
                  {getFieldDecorator('accountNumber', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.accountNumber} />
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.countryCenter} {...formItemLayout}>
                  {getFieldDecorator('countryCenterId', {
                  	initialValue: tryinit('countryCenter'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('countryCenter')}
                    targetType={"countryCenter"} 
                    requestFunction={AccountSetService.requestCandidateCountryCenter}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.retailStore} {...formItemLayout}>
                  {getFieldDecorator('retailStoreId', {
                  	initialValue: tryinit('retailStore'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStore')}
                    targetType={"retailStore"} 
                    requestFunction={AccountSetService.requestCandidateRetailStore}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.goodsSupplier} {...formItemLayout}>
                  {getFieldDecorator('goodsSupplierId', {
                  	initialValue: tryinit('goodsSupplier'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('goodsSupplier')}
                    targetType={"goodsSupplier"} 
                    requestFunction={AccountSetService.requestCandidateGoodsSupplier}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           



			 </Row>
          </Form>
        </Card>








      
       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(AccountSetCreateFormBody))





