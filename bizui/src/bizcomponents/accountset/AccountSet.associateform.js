import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './AccountSet.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import AccountSetBase from './AccountSet.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '账套2017',
  yearSet: '2017年',
  effectiveDate: '2017-02-07',
  accountingSystem: '企业会计制度',
  domesticCurrencyCode: 'RMB',
  domesticCurrencyName: '人民币',
  openingBank: '招商银行',
  accountNumber: '33265805054885',
  countryCenterId: 'RSCC000001',
  retailStoreId: 'RS000001',
  goodsSupplierId: 'GS000001',
}
*/


const imageKeys = [
]


class AccountSetAssociateForm extends Component {
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
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {AccountSetService} = GlobalComponents
 const {AccountingSubjectModalTable} = GlobalComponents;
 const {AccountingPeriodModalTable} = GlobalComponents;
 const {AccountingDocumentTypeModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = AccountSetBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
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
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    
    return (
 <Modal
          title="创建新的支付"
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.yearSet} {...formItemLayout}>
                  {getFieldDecorator('yearSet', {
                    rules: [{ required: true, message: '请输入年组' }],
                  })(
                    <Input placeholder="请输入年组" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.effectiveDate} {...formItemLayout}>
                  {getFieldDecorator('effectiveDate', {
                    rules: [{ required: true, message: '请输入生效日期' }],
                  })(
                    <DatePicker format="YYYY-MM-DD" placeholder="请输入生效日期" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.accountingSystem} {...formItemLayout}>
                  {getFieldDecorator('accountingSystem', {
                    rules: [{ required: true, message: '请输入会计制度' }],
                  })(
                    <Input placeholder="请输入会计制度" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.domesticCurrencyCode} {...formItemLayout}>
                  {getFieldDecorator('domesticCurrencyCode', {
                    rules: [{ required: true, message: '请输入本币代码' }],
                  })(
                    <Input placeholder="请输入本币代码" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.domesticCurrencyName} {...formItemLayout}>
                  {getFieldDecorator('domesticCurrencyName', {
                    rules: [{ required: true, message: '请输入本币名称' }],
                  })(
                    <Input placeholder="请输入本币名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.openingBank} {...formItemLayout}>
                  {getFieldDecorator('openingBank', {
                    rules: [{ required: true, message: '请输入开户银行' }],
                  })(
                    <Input placeholder="请输入开户银行" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.accountNumber} {...formItemLayout}>
                  {getFieldDecorator('accountNumber', {
                    rules: [{ required: true, message: '请输入帐户号码' }],
                  })(
                    <Input placeholder="请输入帐户号码" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.countryCenter} {...formItemLayout}>
                  {getFieldDecorator('countryCenterId', {
                  	initialValue: tryinit('countryCenter'),
                    rules: [{ required: true, message: '请输入全国运营中心' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('countryCenter')}
                    targetType={"countryCenter"} 
                    requestFunction={AccountSetService.requestCandidateCountryCenter}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.retailStore} {...formItemLayout}>
                  {getFieldDecorator('retailStoreId', {
                  	initialValue: tryinit('retailStore'),
                    rules: [{ required: true, message: '请输入双链小超' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('retailStore')}
                    targetType={"retailStore"} 
                    requestFunction={AccountSetService.requestCandidateRetailStore}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.goodsSupplier} {...formItemLayout}>
                  {getFieldDecorator('goodsSupplierId', {
                  	initialValue: tryinit('goodsSupplier'),
                    rules: [{ required: true, message: '请输入产品供应商' }],
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
        
	<AccountingSubjectModalTable data={data.accountingSubjectList} owner={owner} />
	<AccountingPeriodModalTable data={data.accountingPeriodList} owner={owner} />
	<AccountingDocumentTypeModalTable data={data.accountingDocumentTypeList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(AccountSetAssociateForm))




